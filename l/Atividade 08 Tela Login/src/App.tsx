import { useState } from 'react'
import DefaultInput from './components/DefaultInput/DefaultInput'
import DefaultButton from './components/DefaultButton/DefaultButton'
import styles from './App.module.css'

function App() {
  const [nome, setNome] = useState('')
  const [nomeExibido, setNomeExibido] = useState('')

  function handleLogin() {
    setNomeExibido(nome)
  }

  return (
    <div className={styles.container}>
      <div className={styles.loginCard}>
        <h1 className={styles.titulo}>Login</h1>

        <DefaultInput
          label="Nome"
          placeholder="Digite seu nome"
          value={nome}
          onChange={setNome}
        />

        <DefaultButton texto="Entrar" onClick={handleLogin} />

        {nomeExibido && (
          <p className={styles.mensagem}>
            Olá, <strong>{nomeExibido}</strong>! Bem-vindo(a)!
          </p>
        )}
      </div>
    </div>
  )
}

export default App
