import React from "react";
import CustomForm from "../../../components/custom-form";
import inputs from "./inputs";
import ContentEditableBlock from "../../../components/content-editable-block";
import CustomRow from "../../../components/custom-row";

const SignUpRoute = () => {

    const onClick = (form) => {
        console.log(form)
    };

    return (
        <div className="sign-up-route container">

            <h3>Регистрация</h3>

            <CustomForm inputs={inputs} onClick={onClick} />



        </div>
    );
};

export default SignUpRoute;