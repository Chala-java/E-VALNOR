import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import Home from './pages/Home.jsx'
import Header from './components/Header.jsx'
import Admin from './pages/Admin.jsx'


createRoot(document.getElementById('root')).render(
  <StrictMode>
   <Admin/>
  </StrictMode>,
)
