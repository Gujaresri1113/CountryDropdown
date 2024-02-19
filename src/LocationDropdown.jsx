import React, { useState, useEffect } from 'react';
import { Card, CardContent, FormControl, InputLabel, MenuItem, Select, Typography } from '@mui/material';
import axios from 'axios';
import './App.css';

function LocationDropdown() {
    const [countries, setCountries] = useState([]);
    const [states, setStates] = useState([]);
    const [cities, setCities] = useState([]);
    const [selectedCountry, setSelectedCountry] = useState('');
    const [selectedState, setSelectedState] = useState('');
    const [selectedCity, setSelectedCity] = useState('');

    useEffect(() => {
        const fetchCountries = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/country');
                setCountries(response.data);
            } catch (error) {
                console.error('Error fetching countries:', error);
            }
        };

        fetchCountries();
    }, []);

    const handleCountryChange = async (event) => {
        const selectedCountryName = event.target.value;
        setSelectedCountry(selectedCountryName);
        try {
            const response = await axios.get(`http://localhost:8080/api/country/${selectedCountryName}/states`);
            setStates(response.data);
            setCities([]);
        } catch (error) {
            console.error('Error fetching states:', error);
        }
    };

    const handleStateChange = async (event) => {
        const selectedStateName = event.target.value;
        setSelectedState(selectedStateName);
        try {
            const response = await axios.get(`http://localhost:8080/api/country/${selectedStateName}/cities`);
            setCities(response.data);
        } catch (error) {
            console.error('Error fetching cities:', error);
        }
    };
    

    const handleCityChange = (event) =>{
        const selectCityName = event.target.value;
        setSelectedCity(selectCityName);
    }
    return (
        <div className="container">
        <Card className="card">
            <CardContent>
                <Typography variant="h5" component="div" gutterBottom>
                    Location Dropdowns
                </Typography>
                <FormControl fullWidth sx={{ minWidth: 200, marginBottom: 2 }}>
                    <InputLabel id="country-label">Select Country</InputLabel>
                    <Select
                        labelId="country-label"
                        value={selectedCountry}
                        onChange={handleCountryChange}
                    >
                        <MenuItem value="">Select</MenuItem>
                        {countries.map(country => (
                            <MenuItem key={country.id} value={country.name}>{country.name}</MenuItem>
                        ))}
                    </Select>
                </FormControl>
                <FormControl fullWidth sx={{ minWidth: 200, marginBottom: 2 }}>
                    <InputLabel id="state-label">Select State</InputLabel>
                    <Select
                        labelId="state-label"
                        value={selectedState}
                        onChange={handleStateChange}
                    >
                        <MenuItem value="">Select</MenuItem>
                        {states.map(state => (
                            <MenuItem key={state.id} value={state.name}>{state.name}</MenuItem>
                        ))}
                    </Select>
                </FormControl>
                <FormControl fullWidth>
                    <InputLabel id="city-label">Select City</InputLabel>
                    <Select
                        labelId="city-label"
                        value={selectedCity}
                        onChange={handleCityChange}
                    >
                        <MenuItem value="">Select</MenuItem>
                        {cities.map(city => (
                            <MenuItem key={city.id} value={city.name}>{city.name}</MenuItem>
                        ))}
                    </Select>
                </FormControl>
            </CardContent>
        </Card>
    </div>
    );
}

export default LocationDropdown;
