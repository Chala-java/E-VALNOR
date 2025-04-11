import { StrictMode } from "react";
import { createRoot } from 'react-dom/client';
import { BrowserRouter } from "react-router-dom";
import CarritoProvider from "./context/CarritoContext";
import { ModalCarritoProvider } from "./context/ModalCarritoContext";
import Carrito from "./components/Carrito.jsx";
import AppRouter from "./router/AppRouter.jsx";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <CarritoProvider>
      <ModalCarritoProvider>
        <BrowserRouter>
          <Carrito />
          <AppRouter />
        </BrowserRouter>
      </ModalCarritoProvider>
    </CarritoProvider>
  </StrictMode>
);
