import { Route, Routes } from 'react-router-dom'
import { Navbar } from './widgets/Navbar'
import { HomePage } from './pages/Home/ui/HomePage'

const AboutPage = () => <main />
const StocklistsPage = () => <main />
const ContactPage = () => <main />

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/stocklists" element={<StocklistsPage />} />
        <Route path="/contact" element={<ContactPage />} />
      </Routes>
    </>
  )
}

export default App
