import './App.css';
import logo from './logo.svg';
import React from 'react';
import {Route, Switch} from 'react-router';
import {BrowserRouter} from 'react-router-dom';
import Home from './componente/Home';
import RegistrarCliente from "./componente/RegistarCliente";



/*function App() {
    return (
        <form>
            <div className="App">
            <header className="App-header">
            <img src="http://corralondonantonio.com/wp-content/uploads/2019/03/ferreteriaPortada-1.jpg" className="App-logo" alt="ferreteria" />
            <div>
                <p>
                FERRETERÍA BACCO
                </p>
                <p>
                Nuestros clientes
                </p>
                <p>
                Nuestros Productos
                </p>
                <p>
                Registrar un cliente
                </p>
            </div>
            </header>
    </div>
    </form>
);
}

export default App;*/


function App() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/home" render={props => <Home user={props.location.state}/>}/>
                <Route path="/registrarCliente" render={props => <RegistrarCliente user={props.location.state}/>}/>
                <Route path="/" render={props => <Home {...props} />}/>
            </Switch>
        </BrowserRouter>

    );

}


export default App;