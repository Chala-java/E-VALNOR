import { useState, useEffect } from "react";
import Header from "../components/Header";
import ListarProductos from "../components/ListarProductos";
import "../pages/Home.css";
import Presentacion from "../components/Presentacion";

const Home = () => {
  return (
    <html>
      <body>
        <Header />
        <section>
            <Presentacion/>
        </section>
        <section className="lista-producto">
          <ListarProductos />
        </section>
      </body>
    </html>
  );
};

export default Home;
