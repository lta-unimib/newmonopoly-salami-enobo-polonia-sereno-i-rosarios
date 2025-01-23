import React from 'react'
import { useLocation } from 'react-router-dom'

const PartitaRouter = () => {
  const { state } = useLocation()
  return (
    <div>
        {state}

    </div>
  )
}

export default PartitaRouter