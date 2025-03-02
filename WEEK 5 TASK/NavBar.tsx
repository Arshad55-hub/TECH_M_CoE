import { HStack, Image } from "@chakra-ui/react";
import logo from "../assets/Logo.png";
import DarkSwitch from "./DarkSwitch";
function NavBar() {
  return (
    <>
      <HStack justifyContent={"right"}>
        <Image src={logo} boxSize="100px"></Image>
        <DarkSwitch></DarkSwitch>
      </HStack>
    </>
  );
}
export default NavBar;
