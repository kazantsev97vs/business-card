import React from "react";

import CustomButton from "../custom-button";
import "./custom-form.css";
import ContentEditableBlock from "../content-editable-block";
import CustomRow from "../custom-row";

const CustomForm = ({
    inputs,
    onClick,
    width = 450,
    contentEditableBlockWidth = 260,
    contentEditableBlockHeight = 40,
    contentEditableBlockMinHeight = null,
    rowsMargin = "15px 0",
    buttonMargin = `30px 15px`,
    right =  contentEditableBlockWidth - 109
}) => {

    const fields = {};

    for (let i = 0; i < inputs.length; i++) fields[inputs[i].name] = "";

    const getText = (text, id) => fields[inputs.find((item) => item.id === id).name] = text;

    return (
        <div className="custom-form ">

            {
                inputs.map(item => {
                    return (
                        <CustomRow
                            key={item.id}
                            width={width}
                            margin={rowsMargin}
                        >
                            <div>{item.label}</div>
                            <div>
                                <ContentEditableBlock
                                    width={contentEditableBlockWidth}
                                    height={contentEditableBlockHeight}
                                    minHeight={contentEditableBlockMinHeight}
                                    placeholder={item.placeholder}
                                    defaultValue={item.defaultValue}
                                    getText={(text) => getText(text, item.id)}
                                />
                            </div>

                        </CustomRow>
                    );
                })
            }

            <div
                className="custom-form__button  "
                style={{
                    margin: buttonMargin,
                    right: right
                }}
            >
                    <CustomButton onClick={() => onClick(fields)}/>
            </div>

        </div>
    );
};

export default CustomForm;