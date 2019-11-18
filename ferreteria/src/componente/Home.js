import './App.css';
import React from 'react';
import {withRouter} from 'react-router';
import 'bootstrap/dist/css/bootstrap.min.css';


class Home extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {
        return (
            <div className={"Home"}>


            </div>

        );
    }


}

export default withRouter(Home);