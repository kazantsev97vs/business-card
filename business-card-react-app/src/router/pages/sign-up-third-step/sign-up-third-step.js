import React from "react";
import CustomForm from "../../../components/custom-form";
import genderCurrentCity from "./gender-currentCity";
import {fetchUpdateUserRequest, fetchUpdateUserSuccess} from "../../../redux/actions/actions-on-user";
import {compose} from "redux";
import withService from "../../../additional-components/hoc/withService";
import {connect} from "react-redux";

const SignUpThirdStep = ({user, fetchUpdateUserRequest, fetchUpdateUserSuccess}) => {

    const saveGenderCurrentCity = ({gender, currentCity}) => {
        const updatedUser = {...user.user, gender, currentCity};
        fetchUpdateUserRequest();
        fetchUpdateUserSuccess(updatedUser);
    };

    genderCurrentCity[0].radio = [
        {
            id: 1,
            value: "MALE",
            label: "М"
        },
        {
            id: 2,
            value: "FEMALE",
            label: "Ж"
        }
    ];

    genderCurrentCity[1].dropdown = [
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
                onClick={saveGenderCurrentCity}
                href={"/"}
            />

        </div>
    );
};

const mapStateToProps = ({user}) => ({ user });

const mapDispatchToProps = {
    fetchUpdateUserRequest, fetchUpdateUserSuccess
};

export default compose(
    withService(),
    connect(mapStateToProps, mapDispatchToProps)
)(SignUpThirdStep);