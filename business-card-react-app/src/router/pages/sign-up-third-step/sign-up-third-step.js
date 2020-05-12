import React from "react";
import CustomForm from "../../../components/custom-form";
import genderCurrentCity from "./gender-currentCity";

const SignUpThirdStep = () => {

    const saveFirstNameLastNameEmail = (form) => {
        console.log(form)

        // user.firstName = form.firstName;
        // user.lastName = form.lastName;
        // user.email = form.email;

    };

    const dropdowns = [
        {
            id: 1,
            value: "Новосибирск"
        },
        {
            id: 2,
            value: "Бердск"
        },
        {
            id: 3,
            value: "Искитим"
        }
    ];

    return (
        <div>

            <CustomForm
                width={500}
                name="Заполните дополниельные данные"
                inputs={genderCurrentCity}
                onClick={saveFirstNameLastNameEmail}
                href={"/"}
                dropdowns={dropdowns}
            />

        </div>
    );
};

export default SignUpThirdStep;