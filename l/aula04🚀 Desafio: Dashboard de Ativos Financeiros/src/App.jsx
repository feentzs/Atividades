import { CardAtivo } from './components/CardAtivo';
import { Heading } from './components/Heading';
import './styles/theme.css';

export function App() {
  return (
    <div className="container">
      {/* Testando o desafio extra no Heading */}
      <Heading>💰 Meu Portfólio de Lucro 2026</Heading>

      <div className="grid">
        {/* Card de Bitcoin */}
        <CardAtivo titulo="Bitcoin (BTC) 🚀">
          <p>Preço: R$ 350.000,00</p>
          <span style={{ color: 'var(--alta)', fontWeight: 'bold' }}>+5.2% hoje</span>
        </CardAtivo>

        {/* Card de Fundo Imobiliário */}
        <CardAtivo titulo="Fundo Imobiliário (HGLG11) 🏢">
          <p>Dividendo: R$ 1,10</p>
          <span style={{ color: 'var(--alta)', fontWeight: 'bold' }}>Rendimento estável</span>
        </CardAtivo>

        {/* Card de Ação */}
        <CardAtivo titulo="Empresa X (VALE3) 📉">
          <p>Preço: R$ 65,20</p>
          <span style={{ color: 'var(--baixa)', fontWeight: 'bold' }}>-1.8% hoje</span>
        </CardAtivo>
      </div>
    </div>
  );
}

export default App;