import React from "react";

import "./custom-form.css";
import ContentEditableBlock from "../content-editable-block";
import CustomRow from "../custom-row";
import ContentEditableBlockSelect from "../content-editable-block-select";
import CustomButton from "../custom-buttons/custom-button";
import CustomRadioButton from "../custom-buttons/custom-radio-button";

const CustomForm = ({
    name,
    inputs,
    onClick,
    width = 450,
    contentEditableBlockWidth = 260,
    contentEditableBlockHeight = 40,
    contentEditableBlockMinHeight = null,
    rowsMargin = "15px 0",
    buttonMargin = `40px 0 60px`,
    buttonText,
    href,
}) => {

    const fields = {};

    for (let i = 0; i < inputs.length; i++) fields[inputs[i].name] = "";

    const getValueFromContentEditableBlock = (text, id) => fields[inputs.find((item) => item.id === id).name] = text;

    const getValueFromCustomRadioButton = (name, item) => fields[name] = inputs[0].radio.find(radio => item.id === radio.id);

    const content = (item) => {
        switch (item.type) {
            case "select":
                return (
                    <ContentEditableBlockSelect
                        width={contentEditableBlockWidth}
                        height={contentEditableBlockHeight}
                        minHeight={contentEditableBlockMinHeight}
                        placeholder={item.placeholder}
                        defaultValue={item.defaultValue}
                        getText={(text) => getValueFromContentEditableBlock(text, item.id)}
                        dropdown={item.dropdown}
                    />
                );

            case "radio":
                return (
                    <CustomRow>
                        {
                            item.radio.map((itemRadio) => <CustomRadioButton key={itemRadio.id}
                                 id={itemRadio.id}
                                 name={item.name}
                                 label={itemRadio.label}
                                 checked={() => getValueFromCustomRadioButton(item.name, itemRadio)}
                            />)
                        }
                    </CustomRow>
                );

            default:
                return (
                    <ContentEditableBlock
                        width={contentEditableBlockWidth}
                        height={contentEditableBlockHeight}
                        minHeight={contentEditableBlockMinHeight}
                        placeholder={item.placeholder}
                        defaultValue={item.defaultValue}
                        getText={(text) => getValueFromContentEditableBlock(text, item.id)}
                    />
                );
        }
    };

    return (
        <div className="custom-form ">

            {
                name &&
                <CustomRow
                    width={width}
                    margin={"40px 0"}
                >
                    <h3>{name}</h3>
                </CustomRow>
            }

            {
                inputs.map(item => {
                    return (
                        <CustomRow key={item.id} width={item.width ? item.width : width} margin={rowsMargin}>

                            <div>{item.label}</div>

                            { content(item) }

                        </CustomRow>
                    );
                })
            }

            {
                name &&
                <CustomRow width={width} margin={buttonMargin} >
                    <div/>
                    <div
                        className="custom-form__button"
                        style={{width: contentEditableBlockWidth}}
                    >
                        <CustomButton
                            text={buttonText}
                            onClick={() => onClick(fields)}
                            href={href}
                        />
                    </div>
                </CustomRow>
            }
        </div>
    );
};

export default CustomForm;