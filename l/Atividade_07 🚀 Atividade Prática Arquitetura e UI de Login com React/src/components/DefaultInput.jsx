import React from 'react';
import { Mail, Lock } from 'lucide-react';

const DefaultInput = ({ type, placeholder, iconType }) => {
  const IconComponent = iconType === 'mail' ? Mail : Lock;

  return (
    <div style={{ position: 'relative' }}>
      <input
        type={type}
        placeholder={placeholder}
        style={{
          height: '3rem',
          border: '0.0625rem solid var(--text-muted)',
          width: '100%',
          paddingLeft: '2.5rem',
          boxSizing: 'border-box',
          borderRadius: '0.25rem', // optional
          backgroundColor: 'transparent',
          color: 'var(--text-main)'
        }}
        onFocus={(e) => e.target.style.borderColor = 'var(--primary-color)'}
        onBlur={(e) => e.target.style.borderColor = 'var(--text-muted)'}
      />
      <IconComponent
        size="1.25rem"
        style={{
          position: 'absolute',
          left: '0.5rem',
          top: '50%',
          transform: 'translateY(-50%)',
          color: 'var(--text-muted)'
        }}
      />
    </div>
  );
};

export default DefaultInput;