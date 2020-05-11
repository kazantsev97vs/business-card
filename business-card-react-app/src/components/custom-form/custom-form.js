import React from "react";

import ContentEditableBlockWithLabel from "../content-editable-block-with-label";
import CustomButton from "../custom-button";
import "./custom-form.css";

const CustomForm = ({inputs, onClick, width = 380, fieldWidth = 200, paddingTop = 20}) => {

    const fields = {};

    for (let i = 0; i < inputs.length; i++) fields[inputs[i].name] = "";

    const getText = (text, id) => fields[inputs.find((item) => item.id === id).name] = text;

    return (
        <div className="custom-form">

            {
                inputs.map(item => {
                    return (
                        <ContentEditableBlockWithLabel
                            key={item.id}
                            label={item.label}
                            height={item.height}
                            width={width}
                            fieldHeight={item.fieldHeight}
                            fieldMinHeight={item.fieldMinHeight}
                            fieldWidth={fieldWidth}
                            placeholder={item.placeholder}
                            defaultValue={item.defaultValue}
                            getText={(text) => getText(text, item.id)}
                        />
                    );
                })
            }

            <div
                className="custom-form__button"
                style={{
                    paddingLeft: width - fieldWidth - 53,
                    paddingTop: paddingTop
                }}
            >
                <CustomButton onClick={() => onClick(fields)}/>
            </div>

        </div>
    );
};

export default CustomForm;