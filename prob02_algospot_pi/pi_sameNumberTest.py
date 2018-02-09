import unittest

from prob02_algospot_pi.pi import sameNumber


class SameNumberTestCase(unittest.TestCase):
    def test_sameNumber_1(self):
        self.assertEqual(sameNumber('111'), True)

    def test_sameNumber_2(self):
        self.assertEqual(sameNumber('1111'), True)

    def test_sameNumber_3(self):
        self.assertEqual(sameNumber('11111'), True)

    def test_sameNumber_4(self):
        self.assertEqual(sameNumber('222'), True)

    def test_sameNumber_5(self):
        self.assertEqual(sameNumber('221'), False)

    def test_sameNumber_6(self):
        self.assertEqual(sameNumber('2221'), False)

    def test_sameNumber_7(self):
        self.assertEqual(sameNumber('22221'), False)
