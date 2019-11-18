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
                <div className="container" >
                <div className="title">
                    <h2>Ferreteria<br/></h2>
                    <h2>Bacco<br/></h2>
                    {/*<Link target="_blank" to={{pathname: "/RegistrarCliente"}} className="white-mode">Registrarme</Link>*/}
                </div>
            </div>
            </div>

        );
    }


}

export default withRouter(Home);