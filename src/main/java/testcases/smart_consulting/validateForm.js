function validateInsurance(str) {
    const pattern = /^\d{3}-\d{3}-\d{3} \d{2}$/;
    return pattern.test(str);
}

function validateDateOfBirth(str) {
    const pattern = /^\d{2}.\d{2}.\d{4}$/;
    return pattern.test(str);
}

function validateForm(form) {
    if (form.lastName.value.length < 1 || form.lastName.value.length > 40) {
        alert('Фамилия должна содержать от 1 до 40 символов!');
        return false;
    }
    if (form.firstName.value.length < 1 || form.firstName.value.length > 40) {
        alert('Имя должно содержать от 1 до 40 символов!');
        return false;
    }
    if (form.middleName.value.length > 40) {
        alert('Отчество должно содержать до 40 символов!');
        return false;
    }
    if (!validateInsurance(form.insuranceNumber.value)) {
        alert('Номер СНИЛС должен соответствовать виду: 123-456-789 01');
        return false;
    }
    if (!validateDateOfBirth(form.dateOfBirth.value)) {
        alert('Дата рождения должна соответствовать формату: 1990-01-01');
        return false;
    }

    if (form.dataAvailability.value === "") {
        alert('Заполните поле "Наличие данных"');
        return false;
    }

    const year = parseInt(form.insuranceExperienceYear.value);
    if (isNaN(year) || year < 0 || year > 999) {
        alert('Поле общая продолжительность страхового стажа лет не заполнено или выходит допустимые рамки.');
        return false;
    }

    const month = parseInt(form.insuranceExperienceMonth.value);
    if (isNaN(month) || month < 0 || month > 99) {
        alert('Поле общая продолжительность страхового стажа месяцев не заполнено или выходит допустимые рамки.');
        return false;
    }

    const day = parseInt(form.insuranceExperienceDay.value);
    if (isNaN(day) || day < 0 || day > 99) {
        alert('Поле общая продолжительность страхового стажа дней не заполнено или выходит допустимые рамки.');
        return false;
    }

    return true;
}
