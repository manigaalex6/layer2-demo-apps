export type LoginCredentialsDto = {
    email: string;
    password: string;
};

export type RegisterRequestDto = {
    email: string;
    firstname: string;
    lastname: string;
    password: string;
};

export type JwtPayloadDto = {
    access_token: string;
};
