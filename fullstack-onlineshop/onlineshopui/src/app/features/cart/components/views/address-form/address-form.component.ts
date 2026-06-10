import { ChangeDetectionStrategy, Component, input } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { ErrorMessageComponent } from '../../../../../clib/components/error-message/error-message.component';
import { AddressFormGroup } from '../../../utils/address-form.utils';

@Component({
    selector: 'app-address-form',
    standalone: true,
    imports: [ReactiveFormsModule, ErrorMessageComponent],
    templateUrl: './address-form.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class AddressFormComponent {
    form = input.required<AddressFormGroup>();
}
