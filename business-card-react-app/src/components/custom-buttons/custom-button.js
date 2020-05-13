import React from "react";
import {Link} from "react-router-dom";
import "./custom-button.css";

const CustomButton = ({

                          text = "Сохранить",
                          onClick,
                          type = "reset",
                          form = null,
                          href
                      }) => {

    let button = (
        <button
            className="custom-button"
            type={type}
            form={form}
            onClick={onClick}
        >
            {text}
        </button>
    );

    if (href) button = <Link to={href}>{button}</Link>;

    return button;
};

export default CustomButton;