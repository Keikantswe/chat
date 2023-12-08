import React from 'react'

const Login = () => {
  return (
  <div className='formContainer'>
  <div className='formWrapper'>
      <form className='form'>
  
          <span className='title'>Login</span>

          <input type='email' placeholder='email'/>
          <input type='password' placeholder='password'/>
 
          <button> Login </button>

          <p> You dont have an account? Register</p>
      </form>
  </div>
</div>
  )
}

export default Login