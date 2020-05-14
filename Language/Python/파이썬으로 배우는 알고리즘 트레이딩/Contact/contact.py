class Contact:
    def __init__(self, name, phone_number, email, addr): #생성자
        self.name = name;
        self.phone_number = phone_number
        self.email = email
        self.addr = addr

    def print_info(self):
        print("name: "+self.name)
        print("phone: "+self.phone_number)
        print("email: "+self.email)
        print("addr: "+self.addr)

def set_contact():
    name = input("name: ")
    phone_number = input("phone: ")
    email = input("email: ")
    addr = input("addr: ")
    # print(name, phone_number, email, addr)
    new_contact = Contact(name, phone_number, email, addr)
    return new_contact

def print_contact(contact_list):
    for contact in contact_list:
        contact.print_info()
        print('=====================')

def delete_contact(contact_list, name):
    for i, contact in enumerate(contact_list):
        if contact.name == name:
            del contact_list[i]

def print_menu():
    print("1. 연락처 입력")
    print("2. 연락처 출력")
    print("3. 연락처 삭제")
    print("4. 종료")
    num = (int)(input("메뉴 선택: "))
    return num

def store_contact(contact_list):
    f = open("contact_db.txt","wt")
    for contact in contact_list:
        f.write(contact.name + ' ')
        f.write(contact.phone_number+' ')
        f.write(contact.email+' ')
        f.write(contact.addr)
        # f.write(contact.name + '\n')
        # f.write(contact.phone_number +'\n')
        # f.write(contact.email + "\n")
        # f.write(contact.addr + '\n')
    f.close()

def load_contact(contact_list):
    f = open("contact_db.txt", "rt")
    lines = f.readlines()
    num = len(lines)
    num = int(num)
    for i in range(num):
        info = lines[i].split(' ')
        print(info)
        name = info[0]
        phone = info[1]
        email = info[2]
        addr = info[3].rstrip('\n')
        contact = Contact(name, phone, email, addr)
        contact_list.append(contact)

    # num = len(lines)/4
    # num = int(num)
    # for i in range(num):
    #     name = lines[4*i].rstrip('\n')
    #     phone = lines[4*i+1].rstrip('\n')
    #     email = lines[4*i+2].rstrip('\n')
    #     addr = lines[4*i+3].rstrip('\n')
    #     contact = Contact(name, phone, email, addr)
    #     contact_list.append(contact)
    f.close()

def run():
    # kim = Contact('king','010-1234-5678','example@gmail.com','Seoul')
    # kim.print_info()
    # set_contact()
    # f = open("C:\\Users\\DO\\Desktop\\contact_list.txt")
    contact_list = []
    load_contact(contact_list)
    while 1:
        menu = print_menu()
        if menu == 1:
            contact = set_contact()
            contact_list.append(contact)
        elif menu == 2:
            print_contact(contact_list)
        elif menu == 3:
            name = input("input name what you want delete: ")
            delete_contact(contact_list, name)
        elif menu == 4:
            store_contact(contact_list)
            break

if __name__ == "__main__":
    run()