import React from 'react'

const Registration = () => {
  return (
    <div className='formContainer'>
        <div className='formWrapper'>
            <form>
                <span className='title'>Register</span>

                <input type='text' placeholder='name'/>
                <input type='email' placeholder='email'/>
                <input type='password' placeholder='password'/>
                <button>sign up</button>

                <p> You dont have an account? Login</p>
            </form>
        </div>
    </div>
  )
}

export default Registration