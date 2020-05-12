import React from "react";
import "./custom-row.css";

const CustomRow = ({width, margin, children}) => {

    const wrap = (children, idx) => (<div key={idx} className="col">{children}</div>);

    const cols = children.length ? children.map((item, idx) => wrap(item, idx)) : wrap(children);

    return (
        <div
            className="custom-row row align-items-center"
            style={{width, margin}}
        >
            { cols }
        </div>
    );
};

export default CustomRow;