import React from "react";
import "./custom-button.css";

const CustomButton = ({

    text = "Сохранить",
    onClick,
    type = "reset",
    form = null,
}) => {

    return (
        <button
            className="custom-button"
            type={type}
            form={form}
            onClick={onClick}
        >
            {text}
        </button>
    );
};

export default CustomButton;