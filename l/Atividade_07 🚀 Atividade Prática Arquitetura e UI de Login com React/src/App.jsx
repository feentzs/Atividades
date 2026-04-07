import React from 'react';
import Container from './components/Container';
import MainForm from './components/MainForm';
import DefaultInput from './components/DefaultInput';
import DefaultButton from './components/DefaultButton';

const App = () => {
  return (
    <Container>
      <MainForm>
        <form style={{ display: 'flex', flexDirection: 'column', gap: '1.5rem' }}>
          <h1 style={{ color: 'var(--text-main)', margin: 0, textAlign: 'center' }}>Login</h1>
          <DefaultInput type="email" placeholder="Email" iconType="mail" />
          <DefaultInput type="password" placeholder="Password" iconType="lock" />
          <DefaultButton type="submit">Login</DefaultButton>
        </form>
      </MainForm>
    </Container>
  );
};

export default App;