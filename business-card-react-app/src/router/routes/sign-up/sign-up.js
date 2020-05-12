import React from "react";
import CustomForm from "../../../components/custom-form";
import inputs from "./inputs";
import {Link} from "react-router-dom";

const SignUpRoute = () => {

    const onClick = (form) => {
        console.log(form)
    };

    return (
        <div className="sign-up-route container">

            <CustomForm
                name="Регистрация"
                inputs={inputs}
                onClick={onClick}
            />

            <div className="row justify-content-center">
                <Link to="log-in">или войти..?</Link>
            </div>

        </div>
    );
};

export default SignUpRoute;