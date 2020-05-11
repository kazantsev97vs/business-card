import React from "react";
import ContentEditableBlock from "../content-editable-block";
import "./content-editable-block-with-label.css";

const ContentEditableBlockWithLabel = ({
   label = "",

   width = 400,
   height = 70,

   fieldWidth,
   fieldHeight,
   fieldMinHeight,

   placeholder,
   defaultValue,

   getText,
   getHTML,
   onEnterPress,
   onClickOut,
}) => {

    return (
        <div
            className="content-editable-block-with-label"
            style={{
                width: width ? width : 400,
                height: height ? height : 70
            }}
        >

            <div className="label">
                <span>{label}</span>
            </div>

            <div>
                <ContentEditableBlock
                    width={fieldWidth}
                    height={fieldHeight}
                    minHeight={fieldMinHeight}

                    placeholder={placeholder}
                    defaultValue={defaultValue}

                    getText={getText}
                    getHTML={getHTML}
                    onEnterPress={onEnterPress}
                    onClickOut={onClickOut}
                />
            </div>

        </div>
    );
};

export default ContentEditableBlockWithLabel;