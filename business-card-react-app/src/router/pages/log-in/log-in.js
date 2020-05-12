import React from "react";
import {Link} from "react-router-dom";
import inputs from "./inputs";
import CustomForm from "../../../components/custom-form";

const LogInPage = () => {

    return (
        <div className="log-in-route container">

            <CustomForm
                name="Авторизация"
                inputs={inputs}
                onClick={console.log}
                buttonText="Войти"
            />

            <div className="row justify-content-center">
                <Link to="sign-up">или зарегистрироваться..?</Link>
            </div>

        </div>
    );
};

export default LogInPage;