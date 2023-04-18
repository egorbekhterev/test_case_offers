function createXmlDocument(form) {
    const doc = document.implementation.createDocument('', '', null);
    const person = doc.createElement('person');
    const fields = [
      'lastName',
      'firstName',
      'middleName',
      'insuranceNumber',
      'dateOfBirth',
      'dataAvailability',
      'insuranceExperienceYear',
      'insuranceExperienceMonth',
      'insuranceExperienceDay'
    ];

    fields.forEach(field => {
        const fieldElement = doc.createElement(field);
        fieldElement.appendChild(doc.createTextNode(form[field].value));
        person.appendChild(fieldElement);
    });

    doc.appendChild(person);
    return doc;
}


