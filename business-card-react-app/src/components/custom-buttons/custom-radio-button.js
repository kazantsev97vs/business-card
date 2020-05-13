import React from "react";
import "./custom-checkbox-radio-button.css";

const CustomRadioButton = ({name, id, label, checked}) => {

    return (
        <div className="custom-radio-button">
            <input type="radio" name={name} id={id} onChange={(e) => checked(e.target.checked)}/> <label htmlFor={id}>{label}</label>
        </div>
    );
};

export default CustomRadioButton;