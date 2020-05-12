import React from "react";

import {Route, Switch} from "react-router-dom";

import {compose} from "redux";

import withService from "../../additional-components/hoc/withService";

import SignUpFirstStep from "../pages/sign-up-first-step";
import SignUpSecondStep from "../pages/sign-up-second-step";
import SignUpThirdStep from "../pages/sign-up-third-step";

const SignUpRoute = ({match, location, userController}) => {

    return (
        <div className="sign-up-route">

            <Switch >

                <Route exact path={`${match.path}/`} component={ SignUpFirstStep}/>

                <Route exact path={`${match.path}/login&password`} component={SignUpSecondStep}/>

                <Route exact path={`${match.path}/additional-information`} component={SignUpThirdStep}/>

            </Switch>

        </div>
    );
};

export default compose(
    withService()
)(SignUpRoute);