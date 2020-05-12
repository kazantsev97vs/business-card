import React from "react";
import CustomForm from "../../../components/custom-form";
import firstNameLastNameEmail from "./firstName-lastName-Email";
import {Link} from "react-router-dom";

const SignUpFirstStep = ({match}) => {

    const saveFirstNameLastNameEmail = (form) => {
        console.log(form)

        // user.firstName = form.firstName;
        // user.lastName = form.lastName;
        // user.email = form.email;

    };

    return (
        <div>

            <CustomForm
                name="Регистрация"
                inputs={firstNameLastNameEmail}
                onClick={saveFirstNameLastNameEmail}
                href={match.path + "login&password"}
            />

            <div className="row justify-content-center">
                <Link to="log-in">или войти..?</Link>
            </div>

        </div>
    );
};

export default SignUpFirstStep;