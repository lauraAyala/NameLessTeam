import React from 'react';
import axios from 'axios';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import {withRouter} from "react-router";
import Cliente from "./Cliente";
import Table from "react-bootstrap/Table";


class ClientesActivos extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            clientes: []
        }
    }

    componentDidMount() {
        axios.get('http://localhost:7000/clientes/')
            .then(response => {
                this.setState({clientes: response.data});
                console.log("GET Clientes: ", response)
            })
            .catch(error => console.log("**** ERROR ****", error.toJSON()))
    }

    renderClientes() {
        const {clientes} = this.state;
        if (clientes.length === 0) {
            return <div>Todavia no hay Clientes Activos</div>
        }
        return (
            <div className="listaDeClientes">
                <Table striped bordered hover variant="dark">
                    <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Domicilio</th>
                        <th>Telefono</th>
                        <th>CUIT</th>
                    </tr>
                    </thead>
                    <tbody>
                    {clientes.map(cli => <Cliente data={cli}/>)}
                    </tbody>
                </Table>
            </div>
        )
    }

    render() {
        return (
            <div className={"MainPageMiddle"}>
                <h1>Clientes Registrados</h1>
                {this.renderClientes()}
            </div>
        )
    }

}

export default withRouter(ClientesActivos)