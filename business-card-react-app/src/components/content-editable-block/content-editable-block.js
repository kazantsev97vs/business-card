import React, {Component} from "react";
import svgClose from "./close.svg";
import "./content-editable-block.css";

/**
 * ContentEditableBlock - настраиваемое поля ввода.
 *
 *  Список call-back-ов для использующего компонента:
 *      -- getText - вернет использующему компоненту текст поля ввода
 *      -- getHTML - вернет использующему компоненту html поля ввода
 *      -- onEnterPress - при нажатии на клавишу "ENTER" в поле ввода
 *                        вернет использующему компоненту текст и html поля ввода
 *      -- onClickOut - при нажатии за пределами блока поля ввода
 *                      вернет использующему компоненту текст и html поля ввода
 *
 *  Настройки:
 *      --- width - ширина блока поля ввода (по умолчанию: 300)
 *      --- minHeight - минимальная высота блока поля ввода (по умолчанию: 20)
 *      --- height - фиксированная высота блока поля ввода (по умолчанию: null)
 *      --- defaultValue - значение по умолчанию (по умолчанию: "")
 *      --- placeholder (по умолчанию: "")
 *
 *  CSS:
 *      .content-editable-block - этому классу можно указать|изменить следующие свойства:
 *      ---- внешние отступы    : margin
 *      ---- внутренние отступы : padding
 *      ---- рамку              : border
 *      ---- углы               : border-radius
 *      ---- тени               : box-shadow
 *      ---- цвет фона          : background
 *      ---- цвет текста        : color
 *
 *  Обработка нажатия клавиш:
 *      ----- ENTER (13)
 */
export default class ContentEditableBlock extends Component {

    constructor(props) {
        super(props);

        // создание ссылки для хранения DOM-элемента div.content-editable
        this.contentEditable = React.createRef();

        this.state = {
            innerText: "",
            innerHTML: "",
        };
    }

    render() {
        const {width = 200, height, minHeight = 40, placeholder} = this.props;
        const {innerText} = this.state;
        const style = {width: `${width ? width : 200}px`};

        // Если задана конеретная высота
        if (height) {
            // Разрешаем прокрутку текстового поля вправо
            style.minWidth = "fit-content";
        }

        return (
            <div
                className="content-editable-block"
                style={{minHeight: `${height ? height / 2 : minHeight / 2}px`}}
                onClick={this.onClick}
            >
                <div
                    className="content-editable-wrapper"
                >
                    <div
                        className="content-editable"
                        contentEditable
                        style={style}

                        onInput={this.onInput}
                        onKeyPress={this.onKeyPress}

                        ref={this.contentEditable}
                    />
                </div>

                <button
                    className={`content-editable-button button-close ${innerText ? "" : "hidden"}`}
                    onClick={this.onClickButtonClose}
                    tabIndex={-1}
                >
                    <img src={svgClose} alt="close"/>
                </button>

                <div className={`content-editable-placeholder ${innerText ? "hidden" : ""}`}>{placeholder}</div>

            </div>
        );
    }

    componentDidMount() {
        const {defaultValue} = this.props;

        // Если было указано значение по умолчанию для поля ввода
        if (defaultValue) {
            // Устанавливаем значение в поле ввода
            this.contentEditable.current.innerHTML = defaultValue;
            // Запоминаем значение поля ввода
            this.setState({innerText: defaultValue, innerHTML: defaultValue});
        }
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        const {getText, getHTML} = this.props;
        const {innerText, innerHTML} = this.state;

        // Если текст поля ввода изменился
        if (prevState.innerText !== this.state.innerText && getText) {
            // Вернуть актуальный текст поля ввода
            getText(innerText);
        }

        // Если html поля ввода изменился
        if (prevState.innerHTML !== this.state.innerHTML && getHTML) {
            // Вернуть актуальный html поля ввода
            getHTML(innerHTML);
        }
    }

    /**
     * Кнопка очистки поля ввода
     * @param event - событие
     */
    onClickButtonClose = (event) => {
        event.stopPropagation();
        // Очищаем содержимое поля ввода
        this.contentEditable.current.innerHTML = "";
        this.setState({innerText: "", innerHTML: ""});
    };

    /**
     * Действие при вводе
     * @param event - событие
     */
    onInput = (event) => {
        event.stopPropagation();
        // Запоминаем содержимое поля ввода
        this.setState({innerText: event.target.innerText, innerHTML: event.target.innerHTML});
    };

    /**
     * Действия при нажатии клавиш
     * @param event - событие
     */
    onKeyPress = (event) => {
        const {height, onEnterPress} = this.props;
        const {innerText, innerHTML} = this.state;

        // Определяем, что за клавиша была нажата
        switch (event.charCode) {

            // Нажали клавишу ENTER
            case 13:
                // Если задана конеретная высота
                if (height) {
                    // запретить добавление новой строки
                    event.preventDefault();
                }

                // Если пользователь отслеживает событие нажатия клавиши "ENTER"
                if (onEnterPress) {
                    // отправить содержимое поля ввода
                    onEnterPress({innerText, innerHTML});
                }
                break;

            default:
                break;
        }
    };

    /**
     * Действие при нажатии на блок поля ввода
     * @param event - событие
     */
    onClick = (event) => {
        event.stopPropagation();
        const {onClickOut} = this.props;
        // Если пользователь отслеживает клик за пределами блока поля ввода
        if (onClickOut) {
            // навешиваем слушатель на нажатие в окне - "Клик за пределами блока поля ввода"
            window.addEventListener('click', this.clickOutsideInputFieldBlock);
        }
    };

    /**
     * Клик за пределами блока поля ввода
     * @param event - событие
     */
    clickOutsideInputFieldBlock = (event) => {
        event.stopPropagation();
        // удаляем слушатель на нажатие в окне - "Клик за пределами блока поля ввода"
        window.removeEventListener('click', this.clickOutsideInputFieldBlock);

        const {innerText, innerHTML} = this.state;
        const {onClickOut} = this.props;

        // отправить содержимое поля ввода
        onClickOut(innerText, innerHTML);
    };
}