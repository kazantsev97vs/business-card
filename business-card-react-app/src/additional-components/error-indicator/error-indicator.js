import React from "react";

const ErrorIndicator = ({error, errorInfo}) => {
    return (
        <div>
            <div>
                {error}
            </div>
            <div>
                {errorInfo}
            </div>
        </div>
    );
};

export default ErrorIndicator;