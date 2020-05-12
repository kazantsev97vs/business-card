import React from "react";
import {Switch, Route} from "react-router-dom";
import SignUpRoute from "./routes/sign-up/";
import LogInRoute from "./routes/log-in/";

const Router = () => {

    return (
        <div className="router">

            <Switch>

                <Route path="/sign-up" component={SignUpRoute} />

                <Route path="/log-in" component={LogInRoute} />

            </Switch>

        </div>
    );
};

export default Router;