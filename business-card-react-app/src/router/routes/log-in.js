import React from "react";
import {Route} from "react-router-dom";
import LogInPage from "../pages/log-in";

const LogInRoute = () => {

    return (
        <div className="log-in-route">

            <Route path="/" component={LogInPage} />

        </div>
    );
};

export default LogInRoute;