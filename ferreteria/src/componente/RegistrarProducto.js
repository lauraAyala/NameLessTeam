import React, { Component } from 'react';
import { registrarProducto } from './api/Api';
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import Form from "react-bootstrap/Form";
import FormControl from "react-bootstrap/FormControl";
import Button from "react-bootstrap/Button";


export default class RegistrarProducto extends Component {
    constructor(props) {
        super(props);

        this.state = {

            idCodigo: '',
            descripcion:'',
            precioCompra:'',
            precioVenta:'',
            error: ''


        };

        this.changeIdCodigo = this.changeIdCodigo.bind(this);
        this.changeDescripcion = this.changeDescripcion.bind(this);
        this.changePrecioCompra = this.changePrecioCompra.bind(this);
        this.changePrecioVenta = this.changePrecioVenta.bind(this);
        this.executeRegister = this.executeRegister.bind(this);
    }


    changeIdCodigo(event){
        this.setState({idCodigo: event.target.value});
    }

    changeDescripcion(event) {
        this.setState({ descripcion: event.target.value });
    }


    /*changeAplicarDescuento(event) {
      this.setState({ aplicaDescuento: event.target.value });
    }

    changeAplicarPromo(event) {
      this.setState({ aplicaPromo: event.target.value });
    }*/

    changePrecioCompra(event) {
        this.setState({ precioCompra: event.target.value });
    }

    changePrecioVenta(event) {
        this.setState({ precioVenta: event.target.value });
    }

    executeRegister() {
        registrarProducto({ idCodigo: this.state.idCodigo, descripcion: this.state.descripcion, precioCompra: this.state.precioCompra, precioVenta: this.state.precioVenta})
            .then((res)=>{
                console.log(res)
                this.props.history.push('/home');


            }).catch((error) => { this.setState({error:error.response.data.message})


        })

    }

    handleClickBack() {
        this.props.history.push(`home`);
    }

    renderInput(label, value, inputType, onChange) {
        return (
            <div className="form-group row">
                <label className="col-sm-3 col-form-label">{label}</label>
                <div className="col-sm-9">
                    <input type={inputType} className="form-control" value={value} onChange={onChange} />
                </div>
            </div>
        );
    }

    render() {
        return (
            <div>
                <div>
                    <Navbar bg="dark" variant="dark">
                        <Navbar.Brand href="/home">Ferretería</Navbar.Brand>
                        <Nav className="mr-auto">
                            <Nav.Link href="/RegistrarCliente">Registrar Cliente</Nav.Link>
                            <Nav.Link href="/registrarProducto">Registrar Producto</Nav.Link>
                        </Nav>
                        <Form inline>
                            <FormControl type="text" placeholder="Search" className="mr-sm-2"/>
                            <Button variant="outline-info">Search</Button>
                        </Form>
                    </Navbar>
                </div>
                <div  className= "RegistrarProducto">
                    <div className="container" >
                        <Form>

                            <h1> Registrar Producto </h1>
                            <Form.Row>{this.renderInput('IdCodigo', this.state.idCodigo, 'text', this.changeIdCodigo)}</Form.Row>
                            <Form.Row>{this.renderInput('Descripcion', this.state.descripcion, 'text', this.changeDescripcion)}</Form.Row>
                            <Form.Row>{this.renderInput('PrecioCompra', this.state.precioCompra, 'text', this.changePrecioCompra)}</Form.Row>
                            <Form.Row>{this.renderInput('PrecioVenta', this.state.precioVenta, 'text', this.changePrecioVenta)}</Form.Row>

                            <div className="col-12">
                                <button type="button" className="btn btn-primary btn-block" onClick={this.executeRegister}>Registrar</button>
                                <button type="button" className="btn btn-primary btn-block" onClick={() => this.handleClickBack()}>Volver</button>
                            </div>
                        </Form>
                    </div>
                </div>
            </div>
        );
    }
}

