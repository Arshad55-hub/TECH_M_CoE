// Footer.tsx
import { Box, Text, HStack, Link } from "@chakra-ui/react";

function Footer() {
  return (
    <Box p={5} color="white" textAlign="center">
      <Text>© 2025 GameStore. All rights reserved.</Text>
      <HStack justifyContent="center" mt={2}>
        <Link href="#">Privacy Policy</Link>
        <Link href="#">Terms of Service</Link>
        <Link href="#">Contact Us</Link>
      </HStack>
    </Box>
  );
}

export default Footer;
