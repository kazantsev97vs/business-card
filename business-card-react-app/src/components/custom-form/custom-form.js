import React from "react";

import CustomButton from "../custom-button";
import "./custom-form.css";
import ContentEditableBlock from "../content-editable-block";
import CustomRow from "../custom-row";

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
    buttonText


}) => {

    const fields = {};

    for (let i = 0; i < inputs.length; i++) fields[inputs[i].name] = "";

    const getText = (text, id) => fields[inputs.find((item) => item.id === id).name] = text;

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
                        <CustomRow
                            key={item.id}
                            width={width}
                            margin={rowsMargin}
                        >
                            <div>{item.label}</div>

                            <ContentEditableBlock
                                width={contentEditableBlockWidth}
                                height={contentEditableBlockHeight}
                                minHeight={contentEditableBlockMinHeight}
                                placeholder={item.placeholder}
                                defaultValue={item.defaultValue}
                                getText={(text) => getText(text, item.id)}
                            />
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
                        />
                    </div>
                </CustomRow>
            }
        </div>
    );
};

export default CustomForm;