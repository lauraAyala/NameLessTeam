import React from 'react';
import './App.css';

const Cliente = ({data}) => {
    const {nombre, apellido, domicilio, contacto, cuit} = data;

    return (
        <tr>
            <td>{nombre}</td>
            <td>{apellido}</td>
            <td>{domicilio}</td>
            <td>{contacto}</td>
            <td>{cuit}</td>
        </tr>
    );
};

export default Cliente;