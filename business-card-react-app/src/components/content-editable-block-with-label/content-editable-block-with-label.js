import React from "react";
import ContentEditableBlock from "../content-editable-block";
import "./content-editable-block-with-label.css";

const ContentEditableBlockWithLabel = ({
   label = "Label",
   width = 500,
   height = 70,
   fieldWidth = width * 0.6,
   fieldHeight = height,
   placeholder
}) => {

    return (
        <div
            className="content-editable-block-with-label"
            style={{width, height}}
        >

            <div className="label">
                <span>{label}</span>
            </div>

            <div>
                <ContentEditableBlock
                    width={fieldWidth}
                    height={fieldHeight}
                    placeholder={placeholder}
                />
            </div>

        </div>
    );
};

export default ContentEditableBlockWithLabel;