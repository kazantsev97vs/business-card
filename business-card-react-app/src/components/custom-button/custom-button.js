import React from "react";
import "./custom-button.css";

const CustomButton = ({

    text = "Сохранить",
    type = "reset",
    form = null

}) => {

    return (
        <button
            className="custom-button"
            type={type}
            form={form}
        >
            {text}
        </button>
    );
};

export default CustomButton;