import React from "react";
import {Route} from "react-router-dom";

const LogInRoute = () => {

    return (
        <div className="log-in-route">

            <Route path="/" component={LogInRoute} />

        </div>
    );
};

export default LogInRoute;