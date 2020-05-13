import React from "react";
import "./custom-checkbox-radio-button.css";

const CustomCheckbox = ({id, label, checked}) => {
    return (
        <div className="custom-checkbox">
            <input type="checkbox" id={id} onChange={(e) => checked(e.target.checked)}/> <label htmlFor={id}>{label}</label>
        </div>
    );
};

export default CustomCheckbox;