
import './App.css';
import React, { useState,useEffect } from 'react';
function Form() {
  const [formData, setFormData] = useState({
    studentname: '',
    dob: '',
    gender: '',
    newclass: '',
    division: ''
  });
  const [studentData, setStudentData] = useState([])
  useEffect(()=>{
    fetch("http://localhost:8080/api/v1/Student/student").then((res)=>res.json()).then(data=>{
      setStudentData(data)
    })
  },[])
  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };
  const handleSubmit = (event) => {
    event.preventDefault();
    fetch("http://localhost:8080/api/v1/Student/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    })
      .then((response) => {
        if (response.status == 200) {
          // return response.json();
        } else {
          throw new Error("HTTP error " + response.status);
        }
      })
      .then((data) => {
        console.log(data);
        return fetch("http://localhost:8080/api/v1/Student/student");
      })
      .then((response) => {
        if (response.status == 200) {
          return response.json();
        } else {
          throw new Error("HTTP error " + response.status);
        }
      })
      .then((data) => {
        setStudentData(data)
        console.log(data);
      })
      .catch((error) =>{
        console.error("Error:", error);
      });
  };
  

  // const handleSubmit = (event) => {
  //   event.preventDefault();
  //   fetch('http://localhost:8080/api/v1/Student/save', {
  //     method: 'POST',
  //     headers: {
  //       'Content-Type': 'application/json'
  //     },
  //     body: JSON.stringify(formData)
  //   })
  //     .then(response => {if (response.status==200)
  //       {
  //         fetch('http://localhost:8080/api/v1/Student/student')
  //         .then(response => response.json())
  //         .then(data => {
  //           console.log(data);
  //         })
  //         .catch(error => {
  //           console.error('Error fetching data:', error);
  //         });
          
  //       }
  //     })
  
  //     .then(data => {
  //       // Handle response from server
  //     })
  //     .catch(error => {
  //       // Handle error from server
  //     });
  // };
  

  const isFormValid = () => {
    return formData.studentname !== '' && formData.dob !== '' && formData.gender !== '' && formData.newclass !== '' && formData.division !== '';
  };

  return (
    <div>
    <form onSubmit={handleSubmit}>
      <label>
        Name:
        <input
          type="text"
          name="studentname"
          value={formData.studentname}
          onChange={handleInputChange}
          required
        />
      </label>
      <br></br>
      <br></br>
      <label>
        Date of Birth:
        <input
          type="date"
          name="dob"
          value={formData.dob}
          onChange={handleInputChange}
          required
        />
      </label>
      <br></br>
      <br></br>
      <label>
        Gender:
        <label>
          <input
            type="radio"
            name="gender"
            value="male"
            checked={formData.gender === "male"}
            onChange={handleInputChange}
            required
          />
          Male
        </label>
        <label>
          <input
            type="radio"
            name="gender"
            value="female"
            checked={formData.gender === "female"}
            onChange={handleInputChange}
            required
          />
          Female
        </label>
      </label>
      <br></br>
      <br></br>
      <label>
        Class:
        <select
          name="newclass"
          value={formData.newclass}
          onChange={handleInputChange}
          required
        >
          <option value="">Select Class</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
        </select>
      </label>
      <br></br>
      <br></br>
      <label>
        Division:
        <select
          name="division"
          value={formData.division}
          onChange={handleInputChange}
          required
        >
          <option value="">Select Division</option>
          <option value="A">A</option>
          <option value="B">B</option>
          <option value="C">C</option>
        </select>
        <br></br>
        <br></br>
      </label>
      <button type="submit" disabled={!isFormValid()}>
        Submit
      </button>
    </form>
    <div>
      <table border="1" align="right">
        {<tr>
        <td> ID</td>
          <td>Student Name</td>
          <td>DOB</td>
          <td>Gender</td>
            <td>Class</td>
          <td>Division</td>

        </tr>}
        {studentData.length!==0&&studentData.map((item)=>{
          return <>
            <tr key={item.studentid}>
              <td>{item.studentid}</td>
        <td>{item.studentname}</td>
        <td>{item.dob}</td>
        <td>{item.gender}</td>
        <td>{item.newclass}</td>
        <td>{item.division}</td>
      </tr></>
      
        })}
      
      </table>
    </div>
  </div>
  );
}

export default Form;






// const Form = () => {
//   const [formData, setFormData] = useState({
//     name: '',
//     dob: '',
//     gender: '',
//     class: '',
//     division: ''
//   });
//   const[Value,setValue]=useState('')



//   const handleInputChange = (event) => {
//     const { name, value } = event.target;
//     setFormData({ ...formData, [name]: value });
//   };
//   const handleChange = (event) => {
//     const inputRegex = /^[a-zA-Z\s]*$/; // regular expression that only allows letters and spaces
//     if (inputRegex.test(event.target.value)) {
//       setValue(event.target.value);
//     }
//   }
//   const handleSubmit = (event) => {
//     event.preventDefault();
//     fetch('http://localhost:8080/api/v1/Student/save', {
//       method: 'POST',
//       headers: {
//         'Content-Type': 'application/json'
//       },
//       body: JSON.stringify(formData)
//     })
//       .then(response => response.json())
//       .then(data => {
//         // Handle response from server
//       })
//       .catch(error => {
//         // Handle error from server
//       });
//   };

//   const isFormValid = () => {
//     return formData.name !== '' && formData.dob !== '' && formData.gender !== '' && formData.class !== '' && formData.division !== '';
//   };

//   return (
//     <form onSubmit={handleSubmit}>
//       <label>
//         Name:
//         <input type="text" name="name" value={formData.name} onChange={handleChange} required />
//       </label>
//       <label>
//         Date of Birth:
//         <input type="date" name="dob" value={formData.dob} onChange={handleInputChange} required />
//       </label>
//       <label>
//         Gender:
//         <label>
//           <input type="radio" name="gender" value="male" checked={formData.gender === 'male'} onChange={handleInputChange} required />
//           Male
//         </label>
//         <label>
//           <input type="radio" name="gender" value="female" checked={formData.gender === 'female'} onChange={handleInputChange} required />
//           Female
//         </label>
//       </label>
//       <label>
//         Class:
//         <select name="class" value={formData.class} onChange={handleInputChange} required>
//           <option value="">Select Class</option>
//           <option value="1">Class 1</option>
//           <option value="2">Class 2</option>
//           <option value="3">Class 3</option>
//         </select>
//       </label>
//       <label>
//         Division:
//         <select name="division" value={formData.division} onChange={handleInputChange} required>
//           <option value="">Select Division</option>
//           <option value="A">Division A</option>
//           <option value="B">Division B</option>
//           <option value="C">Division C</option>
//         </select>
//       </label>
//       <button type="submit" disabled={!isFormValid()}>Submit</button>
//     </form>
//   );
// }

// export default Form;








// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

//export default App
