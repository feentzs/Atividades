import AnimalCard from './components/AnimalCard';

function App() {
  return (
    <div className="app-container">
      {/* Cabeçalho do Painel */}
      <header className="app-header">
        <span className="app-header__emoji">🌿</span>
        <h1 className="app-header__title">Painel de Monitoramento Selvagem</h1>
        <p className="app-header__subtitle">
          Reserva Ambiental Ecológica — Animais Resgatados
        </p>
      </header>

      {/* Grid de Cartões de Animais */}
      <section className="cards-grid">
        <AnimalCard
          name="Tigre de Bengala"
          species="Panthera tigris tigris"
          isDangerous={true}
        />
        <AnimalCard
          name="Lontra Gigante"
          species="Pteronura brasiliensis"
          isDangerous={false}
        />
        <AnimalCard
          name="Crocodilo-do-Nilo"
          species="Crocodylus niloticus"
          isDangerous={true}
        />
        <AnimalCard
          name="Arara-azul"
          species="Anodorhynchus hyacinthinus"
          isDangerous={false}
        />
        <AnimalCard
          name="Lobo-guará"
          species="Chrysocyon brachyurus"
          isDangerous={false}
        />
        <AnimalCard
          name="Onça-pintada"
          species="Panthera onca"
          isDangerous={true}
        />
      </section>
    </div>
  );
}

export default App;
