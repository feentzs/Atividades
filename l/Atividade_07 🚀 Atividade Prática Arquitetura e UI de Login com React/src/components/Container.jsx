import React from 'react';

const Container = ({ children }) => {
  return (
    <div style={{
      minHeight: '100vh',
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center'
    }}>
      {children}
    </div>
  );
};

export default Container;