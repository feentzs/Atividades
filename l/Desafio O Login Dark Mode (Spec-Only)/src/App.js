import './theme.css';
import './global.css';

export default function App() {
  return (
    <main>
      <h1>Acesso ao Sistema</h1>
      <p>Entre com suas credenciais para continuar.</p>
      
      <input type="email" placeholder="Digite seu e-mail" />
      <input type="password" placeholder="Sua senha secreta" />
      
      <button>Entrar na Plataforma</button>
    </main>
  );
}