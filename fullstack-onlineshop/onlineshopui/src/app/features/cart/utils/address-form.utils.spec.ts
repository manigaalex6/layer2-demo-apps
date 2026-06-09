import { createAddressForm } from './address-form.utils';

describe('createAddressForm', () => {
    it('should create a form with empty default values', () => {
        const form = createAddressForm();

        expect(form.getRawValue()).toEqual({
            country: '',
            city: '',
            county: '',
            streetAddress: ''
        });
    });

    it('should be invalid when all fields are empty', () => {
        const form = createAddressForm();

        expect(form.valid).toBe(false);
    });

    it('should be valid when all fields are filled', () => {
        const form = createAddressForm();
        form.setValue({
            country: 'Romania',
            city: 'Cluj-Napoca',
            county: 'Cluj',
            streetAddress: 'Str. Exemplu 10'
        });

        expect(form.valid).toBe(true);
    });

    it('should be invalid when any field is empty', () => {
        const form = createAddressForm();
        form.setValue({
            country: 'Romania',
            city: 'Cluj-Napoca',
            county: '',
            streetAddress: 'Str. Exemplu 10'
        });

        expect(form.valid).toBe(false);
    });

    it('should enforce maxLength on country', () => {
        const form = createAddressForm();
        form.controls.country.setValue('A'.repeat(101));

        expect(form.controls.country.hasError('maxlength')).toBe(true);
    });

    it('should enforce maxLength on streetAddress', () => {
        const form = createAddressForm();
        form.controls.streetAddress.setValue('A'.repeat(256));

        expect(form.controls.streetAddress.hasError('maxlength')).toBe(true);
    });
});
